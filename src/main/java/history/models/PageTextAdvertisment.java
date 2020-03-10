package history.models;

import lombok.*;

import java.util.HashMap;
import java.util.LinkedList;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PageTextAdvertisment extends Page {
    String url;
    String content;
    HashMap<String, Page> links;
    Integer currentPosition = 0;
    HashMap<Integer, TextAdvertisment> ads;

    @Override
    public Page goToAd() {
        return Browser.getPage(ads.get(currentPosition).getAddUrl());
    }

    @Override
    public String toString() {
        return "\n" + url + " {" + "\n" +
                "  Content='" + content + "'\n" +
                "  Position='" + currentPosition + "'\n" +
                "  Links=" + new LinkedList<>(links.keySet()) +
                "  Ads=" + new LinkedList<>(ads.keySet()) +
                "\n}" + "\n";
    }
}