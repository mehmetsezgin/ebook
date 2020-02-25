package com.mehmet.ebook.parser;

import com.mehmet.ebook.core.JpaApplication;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class HtmlParserApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HtmlParserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        File input = new File("/Users/m.sezgin/Downloads/KATALOG.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements rows = doc.getElementsByTag("tr");
        for (Element row : rows.subList(1,4)) {
            //String linkText = row.text();
            //System.out.println("linkText = " + linkText);
            Elements cells = row.getElementsByTag("td");
            for (Element cell: cells) {
                System.out.println("cell.text() = " + cell.text());
            }
            System.out.println("--------------------------------");
        }
    }
}
