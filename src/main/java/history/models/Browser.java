package history.models;

import history.helper.Reader;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class Browser {
    private Page currentPage;
    private History history;

    public Browser() {
        currentPage = FirstPage.builder()
                .url("index.html")
                .links(new HashMap<>())
                .content("Main page")
                .build();
        this.history = new History();
    }

    public void goBack() {
        history.back(createSnapshot());
        System.out.println(showContent());
    }

    public void goForward() {
        history.forward(createSnapshot());
        System.out.println(showContent());
    }

    public String showContent() {
        return currentPage.toString();
    }

    public Snapshot createSnapshot() {
        return new BrowserShapshot(this, currentPage);
    }

    public void link(String url) {
        Page newPage;
        if ((newPage = (Page) currentPage.getLinks().get(url)) != null) {
            history.link(createSnapshot());
            currentPage = newPage;
        }
        System.out.println(showContent());
    }

    public void goToPage(String url) {
        Page page;
        if ((page = Browser.getPage(url)) != null) {
            currentPage = page;
            history.clearHistory();
            System.out.println(showContent());
        }
    }

    public void goToAd() {
        Page page;
        if ((page = currentPage.goToAd()) != null) {
            history.link(createSnapshot());
            currentPage = page;
            System.out.println(showContent());
        } else {
            System.out.println("There is no ads");
        }
    }

    public void goToAd(String url) {
        history.link(createSnapshot());
        currentPage = Browser.getPage(url);
    }

    public void goToPosition(Integer position) {
        if (!currentPage.changePosition(position)) {
            System.out.println("Incorrect position");
        }
        System.out.println(showContent());
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class BrowserShapshot implements Snapshot {

        private Browser browser;
        private Page snapshotStage;


        public void recover() {
            browser.currentPage = snapshotStage;
        }
    }

    static Map<String, Page> pages;

    public static void connection() {
        Reader pageReader = new Reader("pages.txt");
        pages = pageReader.readPages();
    }

    public static Page getPage(String url) {
        Page page;
        if ((page = pages.get(url)) != null) {
            return page;
        } else {
            System.out.println("Error 404");
            return null;
        }
    }

}
