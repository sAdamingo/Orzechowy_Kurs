package com.sAdamingo.course.Task22;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.stream.Stream;

public class DataBaseOperator<T> implements DataBase<T> {

    private String fileName;
    private long lastId;
    ObjectMapper objectMapper = new ObjectMapper();
    Class<T> clazz;

    public DataBaseOperator(String fileName, Object obj) throws IOException {
        this.fileName = fileName;
        lastId = getLines().mapToLong(this::getIdFromLine).max().orElse(0);
        this.clazz = (Class<T>) obj.getClass();
    }

    private long getIdFromLine(String line) {
        return Long.parseLong(line.substring(0, line.indexOf(':')));
    }

    public void add(T object) throws IOException {
        String json = ++lastId + ":" + objectMapper.writeValueAsString(object) + "\n";
        Files.write(
                Paths.get(fileName),
                json.getBytes(),
                StandardOpenOption.APPEND);
    }

    public T findById(long id) throws IOException {
        return getLines().filter(line -> getIdFromLine(line) == id)
                .map(this::getObjectFromLine).findAny().orElse(null);
    }

    private T getObjectFromLine(String line) {
        try {
            return (T) objectMapper.readValue(
                    getContentFromLine(line), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getContentFromLine(String line) {
        return line.substring(line.indexOf(':') + 1);
    }

    public T getByJsonContainsWord(String word) throws IOException, IllegalArgumentException {
        //noinspection OptionalGetWithoutIsPresent
        Optional<T> any = getLines()
                .filter(line -> getContentFromLine(line).toLowerCase().contains(word.toLowerCase()))
                .map(this::getObjectFromLine).findAny();
        if (any.isPresent()) {
            return any.get();
        } else {
            throw new IllegalArgumentException("Object not Found");
        }
    }

    private Stream<String> getLines() throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            path.toFile().createNewFile();
        }
        return Files.lines(path);
    }

    public Long findObjectId(T object) throws IOException {
        return getLines()
                .filter(line -> getObjectFromLine(line).equals(object))
                .map(this::getIdFromLine)
                .findAny().orElse(null);
    }
}