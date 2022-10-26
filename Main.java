import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws scannerExept{
        Scanner console = new Scanner(System.in);
        Main lot = new Main();
        String exp = new String(lot.calc(console.nextLine()));

    }

    public static String calc(String Input) throws scannerExept{
        String Result = new String(Input);
        Convert convert = new Convert();
        String[] sings = {"+", "-", "/", "*"};//массив самх сиволов
        String[] singsF = {"\\+", "-", "/", "\\*"};// массив их значений
        int singsIndex = -1;
        int i = 0;//нужно чтобы проверить ввелся ли знак, мало ли
        for ( i=0; i < sings.length; i++) {
            if (Result.contains(sings[i])) {
                singsIndex = i;
                break;
            }
        }
        if (singsIndex == -1) {
            System.out.println("Введите знак");//нет знака +,-,*,/;
            //return (null);
        }
        Result = Result.replaceAll(" ","");
        String[] ch = Result.split(singsF[singsIndex]);
        if (ch.length >2)throw new scannerExept("только два числа");
        if(convert.isRoman(ch[0]) == convert.isRoman(ch[1])){
            int a,b;
            boolean isRoman = convert.isRoman(ch[0]);//смотрим римские ли
            if(isRoman) {
                a = convert.romanToInt(ch[0]); if((a< 1)|| (a>11)) {throw new scannerExept("диапазон чисел 1-10");}
                b = convert.romanToInt(ch[1]); if((b< 1)|| (b>11)) {throw new scannerExept("диапазон чисел 1-10");}

            }else{
                a = Integer.parseInt(ch[0]);if((a< 1)|| (a>11)) {throw new scannerExept("диапазон чисел 1-10");}
                b = Integer.parseInt(ch[1]);if((b< 1)|| (b>11)) {throw new scannerExept("диапазон чисел 1-10");}
            }
            int result;
            switch (sings[singsIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if(isRoman){
                if (result<0){throw new scannerExept("Меньше нуля");}
                System.out.println(convert.intToRoman(result));//вывыодим римскими
            }
            else{
                System.out.println(result);//выводим арабскими
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }
        return Result;
    }

}
