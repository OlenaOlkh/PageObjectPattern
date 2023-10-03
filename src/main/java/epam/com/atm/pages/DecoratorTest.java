package epam.com.atm.pages;

public class DecoratorTest {
    public void logic(Writer writer){
        writer.write("Hello world");
    }

    public void test(){
        Writer writer = new BaseWriter();
        Writer writer2 = new WriterDecorator(writer);
        logic(writer2);

    }
}
