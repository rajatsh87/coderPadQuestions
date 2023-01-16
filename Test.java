import java.io.IOException;

import org.w3c.dom.Document;

public class Test {
    public static void main(String[] args) throws JSONException, IOException {
        // URL url = new URL("some_url");
        Document doc = Jsoup.parse(url, 3000);
    
        ArrayList<String> downServers = new ArrayList<>();
        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");
    
        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");
    
            if (cols.get(3).text().equals("Titan")) {
                if (cols.get(7).text().equals("down"))
                    downServers.add(cols.get(5).text());
    
                do {
                    if(i < rows.size() - 1)
                       i++;
                    row = rows.get(i);
                    cols = row.select("td");
                    if (cols.get(7).text().equals("down") && cols.get(3).text().equals("")) {
                        downServers.add(cols.get(5).text());
                    }
                    if(i == rows.size() - 1)
                        break;
                }
                while (cols.get(3).text().equals(""));
                i--;
            }
        }
        System.out.println(downServers);
    }   
}
