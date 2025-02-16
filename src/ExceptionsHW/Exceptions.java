//        Есть строка вида: "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0"; (другими словами матрица 4x4)
//        10 3 1 2
//        2 3 2 2
//        5 6 7 1
//        300 3 1 0
//        Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
//        2. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
//        3. Ваши методы должны бросить исключения в случаях:
//        Если размер матрицы, полученной из строки, не равен 4x4;
//        Если в одной из ячеек полученной матрицы не число; (например символ или слово)
//        4. В методе main необходимо вызвать полученные методы, обработать возможные исключения и вывести результат расчета.
//        5. * Написать собственные классы исключений для каждого из случаев

package ExceptionsHW;

public class Exceptions {

    public static String[][] makeMatrix(String str) throws Exception{
        String[][] result = new String[4][4];
        String tempStr = "";
        int i = 0;
        int j = 0;
        for (char c : str.toCharArray()){
            if (c == ' '){
                result[i][j] = tempStr;
                tempStr = "";
                j++;
                if (j > 3){
                    throw new WrongMatrixFormatException("Ширина больше 4");
                }
            }
            else if (c == '\n'){
                result[i][j] = tempStr;
                tempStr = "";
                j = 0;
                i++;
                if (i > 3){
                    throw new WrongMatrixFormatException("Высота больше 4");
                }
            }
            else {
                tempStr += c;
            }
        }
        result[i][j] = tempStr;

        return result;
    }

    public static float calculateMatrix(String[][] matrix) throws Exception{
        float result = 0;
        for (String[] st : matrix){
            for (String st1 : st){
                if (st1.matches("-?\\d+")){
                    result += Integer.parseInt(st1);
                }
                else {
                    throw new WrongNumberException("Не числовой элемент");
                }
            }
        }
        return result / 2f;
    }

    public static void main(String[] args) {
        String inputStr = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        try {
            String matrix[][] = makeMatrix(inputStr);
            System.out.println(calculateMatrix(matrix));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
