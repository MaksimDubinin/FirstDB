public class Main {
    public static void main(String[] args) {
        MyConnect connection = new MyConnect();
        String select = """
                Select revisinNumber, productType, adress
                from audit_department;
                """;

        String[][] object = connection.allSelect(select);
        System.out.println("----------------------------------------------------------------");
        System.out.printf("|%-20s|%-20s|%-20s| \n", "Ревизионный номер", "Тип изделий", "Адресс расположения");
        System.out.println("----------------------------------------------------------------");

        for (int i = 0; i < object.length; ++i) {
            for (int j = 0; j < object[0].length; ++j) {
                System.out.printf("|%-20s", object[i][j]);
            }
            System.out.println("|");
            System.out.println("----------------------------------------------------------------");
        }
    }

}