package history.helper;

import history.factory.AdvertismentFactory;
import history.factory.TextAdvertismentFactory;
import history.factory.VideoAdvertismentFactory;
import history.models.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reader {
    private Scanner scanner;
    private AdvertismentFactory factory;


    public Reader(String path) {
        try {
            scanner = new Scanner(new FileReader(new File(path)));
        } catch (FileNotFoundException e) {
            System.out.println();
            throw new IllegalArgumentException(e);
        }
    }

    public Map<String, Page> readPages() {
        int countOfPage = scanner.nextInt();
        Map<String, Page> pageMap = new HashMap<>();
        for (int i = 0; i < countOfPage; i++) {
            String[] param = scanner.nextLine().split("=");
            switch (param[0]) {
                case "First":
                    pageMap.put(param[1], FirstPage.builder()
                            .url(param[1])
                            .content(param[2])
                            .links(new HashMap<>())
                            .build());
                    break;
                case "TextAd":
                    pageMap.put(param[1], PageTextAdvertisment.builder()
                            .url(param[1])
                            .content(param[2])
                            .links(new HashMap<>())
                            .ads(new HashMap<>())
                            .build());
                    break;
                case "VideoAd":
                    pageMap.put(param[1], PageVideoAdvertisment.builder()
                            .url(param[1])
                            .content(param[2])
                            .links(new HashMap<>())
                            .ads(new HashMap<>())
                            .build());
                    break;
            }
        }
        for (int i = 0; i < countOfPage && scanner.hasNext(); i++) {
            String[] param = scanner.nextLine().split(":");
            if (param.length > 1) {
                String[] links = param[1].split(" ");
                for (String link : links) {
                    pageMap.get(param[0]).getLinks().put(link, pageMap.get(link));
                }
            }
        }

        try {
            scanner = new Scanner(new FileReader(new File("ads.txt")));
        } catch (FileNotFoundException e) {
            System.out.println();
            throw new IllegalArgumentException(e);
        }

        while (scanner.hasNext()) {
            String[] param = scanner.nextLine().split(":");
            String[] ads = param[2].split(" ");
            switch (param[0]) {
                case "VideoAd":
                    factory = VideoAdvertismentFactory.getInstance();
                    for (String ad : ads) {
                        String[] adPage = ad.split("=");
                        ((PageVideoAdvertisment) pageMap.get(param[1])).getAds().put(Integer.parseInt(adPage[1]), (VideoAdvertisment) factory.createAdvertisment(adPage[0]));
                    }
                    break;
                case "TextAd":
                    factory = TextAdvertismentFactory.getInstance();
                    for (String ad : ads) {
                        String[] adPage = ad.split("=");
                        ((PageTextAdvertisment) pageMap.get(param[1])).getAds().put(Integer.parseInt(adPage[1]), (TextAdvertisment) factory.createAdvertisment(adPage[0]));
                    }
                    break;
            }
        }
        return pageMap;
    }
}
