import java.util.Scanner;

public class This {
    public static void main(String[] args) {
        String output = "public class ";
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the name of the class?");
        String className = scan.nextLine();
        output += className;
        output += " {\n";
        System.out.println("How many attributes are there?");
        int attributesCount = scan.nextInt();
        scan.nextLine(); // skip over newline
        String getter = "";
        String type;
        String name;
        String camelName;
        String constructor = "\n    public " + className + "(";
        String constructorInternals = "\n";
        String setter = "";
        for (int i = 0; i < attributesCount; i++) {
            System.out.println("Enter the type of attribute #" + i + ": ");
            type = scan.nextLine();
            output += "    private " + type;
            getter += "    public " + type + " get";
            setter += "    public void set";
            constructor += type;
            System.out.println("Enter the name of attribute #" + i + ": ");
            name = scan.nextLine();
            camelName = name.substring(0, 1).toUpperCase()
                + name.substring(1, name.length());
            output += " " + name + ";\n";
            getter += camelName
                + "() {\n        return " + name + ";\n    }\n\n";
            setter += camelName
                + "(" + type + " "
                + name
                + ") {\n        this." + name + " = "
                + name + ";\n    }\n\n";
            constructor += " " + name + ", ";
            constructorInternals += "        this." + name + " = " + name + ";\n";
        }
        System.out.println(output + constructor.substring(0, constructor.length() - 2) + ") {" + constructorInternals + "    }\n\n" + getter + setter + "}");
        scan.close();
    }
}