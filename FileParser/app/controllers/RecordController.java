package controllers;

import models.DatabaseExecutionContext;
import models.Record;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * Created by sudheer on 9/14/17.
 */
public class RecordController extends Controller {

    private DatabaseExecutionContext dbEc;
    private FormFactory formFactory;
    private Counter counter;

    @Inject
    public RecordController(FormFactory formFactory, DatabaseExecutionContext ec, Counter counter) {
        this.formFactory = formFactory;
        this.dbEc = ec;
        this.counter=counter;
    }


    public CompletionStage<Result> addRecord() {
        Logger.info("Request number " + Integer.toString(counter.nextCount()));
        Logger.info("Trying to add the Record in the DB");
        Form<Record> userForm = formFactory.form(Record.class).bindFromRequest();

            return CompletableFuture.supplyAsync(() -> {
                if (userForm.hasErrors()) {
                    Logger.info("Adding to DB failed");
                    return badRequest(userForm.errors().toString());
                } else {
                    Record record = userForm.get();
                    record.save();
                    Logger.info("Succesfully added the Record in the DB");
                    return ok(record.id.toString());
                }}
                , dbEc);
    }

    public CompletionStage<Result> getRecords() {
        Logger.info("Request number " + Integer.toString(counter.nextCount()));
        Logger.info("Getting the Records in the DB");
        return CompletableFuture.supplyAsync((() ->
        {
            String listString = Record.find.all().stream().map(Object::toString).collect(Collectors.joining("\n"));
            return listString;
        }), dbEc).thenApplyAsync((res)->ok(res));
    }

}