package epam.com.atm.pages;

public class WriterDecorator implements Writer {
    private Writer decoratedwriter;
    @Override
    public void write(String text) {
        String translatedtext = translate(text);
        decoratedwriter.write(translatedtext);
    }
    public WriterDecorator(Writer writer) {
        decoratedwriter = writer;
    }
    public String translate(String text){
        return "translated" + text;
    }
}

