package com.sAdamingo.course.Task18;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class DataBaseOperator<T> {

    private final String fileName;
    private long lastId;
    ObjectMapper objectMapper = new ObjectMapper();

    public DataBaseOperator(String fileName) throws IOException {
        this.fileName = fileName;
        lastId = getLines().mapToLong(this::getIdFromLine).max().orElse(0);
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
            return objectMapper.readValue(
                    getContentFromLine(line), new TypeReference<T>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getContentFromLine(String line) {
        return line.substring(line.indexOf(':') + 1);
    }

    public T getByJsonContainsWord(String word) throws IOException {
        return getLines()
                .filter(line -> getContentFromLine(line).toLowerCase().contains(word.toLowerCase()))
                .map(this::getObjectFromLine).findAny().get();
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

    public static void main(String[] args) throws ExecutionException, IOException, ParseException {
        System.out.println("Welcome to DataBase Operator!");

    }
}