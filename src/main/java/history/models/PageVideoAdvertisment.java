package history.models;

import history.helper.Context;
import lombok.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageVideoAdvertisment extends Page {
    String url;
    String content;
    HashMap<String, Page> links;
    Integer currentPosition = 0;
    HashMap<Integer, VideoAdvertisment> ads;

    @Override
    public boolean changePosition(Integer position) {
        if (position > 99 || position < 0) {
            return false;
        } else {
            currentPosition = position;
            for (Map.Entry<Integer, VideoAdvertisment> ad : ads.entrySet()) {
                if (ad.getKey() < position && !ad.getValue().isWatched()) {
                    Context.getBrowser().goToAd(ad.getValue().getAdUrl());
                    ad.getValue().setWatched(true);
                    break;
                }
            }
            return true;
        }
    }

    @Override
    public Page goToAd() {
        if (ads.get(currentPosition) != null) {
            return Browser.getPage(ads.get(currentPosition).getAdUrl());
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "\n" + url + " {" + "\n" +
                "  Content='" + content + "'\n" +
                "  Position='" + currentPosition + "'\n" +
                "  Links=" + new LinkedList<>(links.keySet()) + "'\n" +
                "  Ads=" + new LinkedList<>(ads.keySet()) +
                "\n}" + "\n";
    }
}
