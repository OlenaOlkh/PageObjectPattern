package epam.com.atm.pages;

public class BaseWriter implements Writer {

    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
