package DNA3.service;

import DNA3.exception.MyException;

import java.io.FileNotFoundException;

public interface DemoService {
    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException;
}
