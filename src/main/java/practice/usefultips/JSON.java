package practice.usefultips;

import org.json.JSONObject;

public class JSON {

    String informationInJsonFormat = "students: [" +
            "{name: ali, class:programming, contact:546698745}, " +
            "{name: max, class:algorithm, contact:1234587562}," +
            "{name: sara, class:designing, contact:7854245874}" +
            "]";
    JSONObject jsonObject = new JSONObject(informationInJsonFormat);

}
