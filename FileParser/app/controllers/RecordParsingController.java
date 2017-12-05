package controllers;

import utils.ParsingUtil;
import com.google.inject.Inject;
import models.Record;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;


/**
 * Created by sudheer on 9/15/17.
 */
public class RecordParsingController extends Controller {


    private HttpExecutionContext ec;
    private ParsingUtil parsingUtil;
    private Counter counter;

    @Inject
    public RecordParsingController(HttpExecutionContext ec, ParsingUtil parsingUtil, Counter counter) {
        this.ec = ec;
        this.parsingUtil = parsingUtil;
        this.counter = counter;
    }

    public CompletionStage<Result> getRecordsFromFile(boolean apiFormat, boolean requireNames) {
        Logger.info("Inside getRecordsFromFile Method");
        Logger.info("Request number " + Integer.toString(counter.nextCount()));
        CompletableFuture<Result> resp = null;

        //Question 2
        String fileName =  System.getProperty("user.home") + File.separator + "parserApp"+File.separator+"files"+File.separator+"String.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //Question 3
            ArrayList<Record> recordList = new ArrayList<>();
            stream.map(line -> parsingUtil.convertToRecordEntiry(line))
                    .forEach(record -> {
                        if (record != null) recordList.add(record);
                    });

            resp = CompletableFuture.supplyAsync(() -> ok(parsingUtil.colorWiseCount(recordList, apiFormat, requireNames)), ec.current());

        } catch (IOException e) {
            Logger.error("There is a problem with the file. It either doesnt exist or it cant be processed");
        }

        return resp;
    }

}

