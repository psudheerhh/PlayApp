package utils;

import com.google.inject.Inject;
import models.Record;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import play.Logger;
import play.libs.concurrent.HttpExecutionContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by sudheer on 9/15/17.
 */
public class ParsingUtil {

    private HttpExecutionContext ec;

    @Inject
    public ParsingUtil(HttpExecutionContext ec) {
        this.ec = ec;
    }

    public ParsingUtil() {
    }

    public Record convertToRecordEntiry(String line) {
        Logger.info("Inside convertToRecordEntiry Method");
        Record record = null;
        String[] lineArray = line.split(",");
        int arrayLength = lineArray.length;
        if (arrayLength == 4) {
            record = new Record();
            if (validateCombFNameAndLName(lineArray[0])) {
                String[] fNameAndLName = lineArray[0].split(" ");
                record.setFirstName(fNameAndLName[0].replaceFirst("^\\s*", ""));
                record.setLastName(fNameAndLName[1].replaceFirst("^\\s*", ""));
            }
            if (validateColor(lineArray[1])) {
                record.setColor(lineArray[1].replaceFirst("^\\s*", ""));
            }
            if (validateZipCode(lineArray[2])) {
                record.setZipCode(lineArray[2].replaceFirst("^\\s*", ""));
            }
            if (validatePhoneNumber(lineArray[3])) {
                record.setPhoneNumber(lineArray[3].replaceFirst("^\\s*", ""));
            }

        } else if (arrayLength == 5) {
            record = new Record();
            if (validateCombFNameAndLName(lineArray[0])) {
                String[] fNameAndLName = lineArray[0].split(" ");
                record.setFirstName(fNameAndLName[0].replaceFirst("^\\s*", ""));
                record.setLastName(fNameAndLName[1].replaceFirst("^\\s*", ""));
                if (validateAddress(lineArray[1])) {
                    record.setAddress(lineArray[1].replaceFirst("^\\s*", ""));
                }
                if (validateZipCode(lineArray[2])) {
                    record.setZipCode(lineArray[2].replaceFirst("^\\s*", ""));
                }
                if (validatePhoneNumber(lineArray[3])) {
                    record.setPhoneNumber(lineArray[3].replaceFirst("^\\s*", ""));
                }
                if (validateColor(lineArray[4])) {
                    record.setColor(lineArray[4].replaceFirst("^\\s*", ""));
                }
            } else if (validateFNameOrLName(lineArray[0])) {
                if (validateFNameOrLName(lineArray[0])) {
                    record.setLastName(lineArray[0].replaceFirst("^\\s*", ""));
                }
                if (validateFNameOrLName(lineArray[1])) {
                    record.setFirstName(lineArray[1].replaceFirst("^\\s*", ""));
                }
                record = setterBasedOntypeOfField(lineArray[2], record);
                if (record == null) {
                    return record;
                }
                record = setterBasedOntypeOfField(lineArray[3], record);
                if (record == null) {
                    return record;
                }
                record = setterBasedOntypeOfField(lineArray[4], record);
                if (record == null) {
                    return record;
                }
            }

        }
        return record;
    }

    public String colorWiseCount(ArrayList<Record> arr, boolean apiFormat, boolean requireNames) {
        Logger.info("Inside colorWiseCount Method");

        Map<String, ArrayList<String>> colorNamesMap = new HashMap();

        String color;
        for (Record e : arr) {
            if (e != null) {
                color = e.getColor();
                if (color != null) {
                    ArrayList l;
                    if (colorNamesMap.get(color) != null) {
                        l = colorNamesMap.get(color);
                        l.add(e.getFirstName() + " " + e.getLastName());
                    } else {
                        l = new ArrayList<>();
                        l.add(e.getFirstName() + " " + e.getLastName());
                        colorNamesMap.put(color, l);
                    }
                }

            }
        }
        if (apiFormat) return createApiFormat(colorNamesMap, requireNames);
        else return createCountLineByLine(colorNamesMap, requireNames);
    }

    public String createApiFormat(Map<String, ArrayList<String>> map, boolean requireNames) {

        Logger.info("Inside createApiFormat Method");

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();
        ArrayNode childNodes = mapper.createArrayNode();

        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            JsonNode element = mapper.createObjectNode();
            if (requireNames) {
                ArrayNode arrayNode = ((ObjectNode) element).putArray("names");
                for (String item : (ArrayList<String>) pair.getValue()) {
                    arrayNode.add(item);
                }
            }
            ((ObjectNode) element).put("color", (String) pair.getKey());
            ((ObjectNode) element).put("count", ((ArrayList<String>) pair.getValue()).size());
            childNodes.add(element);
            it.remove();
        }

        ((ObjectNode) rootNode).put("colorCountJson", childNodes);
        String apiFormat = null;
        try {
            apiFormat = mapper.writeValueAsString(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiFormat;
    }

    public String createCountLineByLine(Map<String, ArrayList<String>> map, boolean requireNames) {

        Logger.info("Inside createCountLineByLine Method");

        Iterator it = map.entrySet().iterator();
        StringBuilder colorCountString = new StringBuilder("");
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            colorCountString.append(pair.getKey()).append(" ").append(((ArrayList<String>) pair.getValue()).size());
            if (requireNames) {
                String namesList = String.join(",", map.get(pair.getKey()));
                colorCountString.append(" ").append(namesList);
            }
            colorCountString.append("\n");
            it.remove();
        }
        return colorCountString.toString();
    }

    public boolean validateCombFNameAndLName(String fName_LName) {
        return fName_LName.matches("^[A-Z][a-z]*\\s*[A-Z][a-z]*$");
    }

    public boolean validateColor(String color) {
        return color.matches("^\\s*[A-Z][a-z]*$");
    }

    public boolean validateFNameOrLName(String fNameOrLName) {
        return fNameOrLName.matches("^\\s*[A-Z][a-z]*$");
    }

    public boolean validateZipCode(String zipCode) {
        return zipCode.matches("^\\s*[0-9]{5}(?:-[0-9]{4})?$");
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\s*[1-9][0-9]{2}\\s[0-9]{3}\\s[0-9]{4}$") ||
                phoneNumber.matches("^\\s*[1-9][0-9]{2}-[0-9]{3}-[0-9]{4}$") ||
                phoneNumber.matches("^\\s*\\([1-9][0-9]{2}\\)-[0-9]{3}-[0-9]{4}$");
    }

    public boolean validateAddress(String address) {
        return address.matches("^(?:\\s*[0-9]{0,5})?\\s*[A-Z][a-z\\s]*")
                ;
    }

    public Record setterBasedOntypeOfField(String field, Record e) {
        if (validateColor(field)) {
            e.setColor(field.replaceFirst("^\\s*", ""));
            return e;
        } else if (validatePhoneNumber(field)) {
            e.setPhoneNumber(field.replaceFirst("^\\s*", ""));
            return e;
        } else if (validateZipCode(field)) {
            e.setZipCode(field.replaceFirst("^\\s*", ""));
            return e;
        } else {
            return null;
        }
    }
}
