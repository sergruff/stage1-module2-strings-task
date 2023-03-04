package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature resultMethodSignature;
        String[] stringsAndArgs = signatureString.split("\\(");
        String[] modifierTypeName = stringsAndArgs[0].split(" ");
        String args = stringsAndArgs[1].replaceAll("\\)", "");
        if (args.isEmpty()){
            resultMethodSignature = new MethodSignature(modifierTypeName[modifierTypeName.length - 1]);
        } else {
            resultMethodSignature = new MethodSignature(modifierTypeName[modifierTypeName.length - 1], getArgumentsFromString(args));
        }
        resultMethodSignature.setReturnType(modifierTypeName[modifierTypeName.length - 2]);
        if (modifierTypeName.length == 3) {
            resultMethodSignature.setAccessModifier(modifierTypeName[0]);
        }
        return resultMethodSignature;
    }

    private static List<MethodSignature.Argument> getArgumentsFromString(String arg) {
        if (arg.isEmpty()) {
            return null;
        }
        String[] argumentStrings = arg.split(", ");
        List<MethodSignature.Argument> arguments = new ArrayList<>();
        for (String s :
                argumentStrings) {
            arguments.add(new MethodSignature.Argument(s.split(" ")[0], s.split(" ")[1]));
        }
        return arguments;
    }
}
