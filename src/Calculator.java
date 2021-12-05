public class Calculator {
    public String calculate(String firstValue, String secondValue, String operation) {
        String result = "";
        if (!containsQuote(firstValue) && firstValue.length() > 10) {
            throw new RuntimeException("Неправильный ввод");
        }
        firstValue = removeQuotes(firstValue);
        switch (operation) {
            case "+":
                if (containsQuote(secondValue)) {
                    secondValue = removeQuotes(secondValue);
                    result = firstValue + secondValue;
                } else {
                    throw new RuntimeException("Неправильный ввод");
                }
                break;
            case "-":
                if (containsQuote(secondValue)) {
                    secondValue = removeQuotes(secondValue);
                    result = firstValue.replaceAll(secondValue, "");
                } else {
                    throw new RuntimeException("Неправильный ввод");
                }
                break;
            case "/":
                if (isDigit(secondValue) && Integer.parseInt(secondValue) <= 10 && Integer.parseInt(secondValue) > 0) {
                    result = firstValue.substring(0, firstValue.length() / Integer.parseInt(secondValue));
                } else {
                    throw new RuntimeException("Неправильный ввод");
                }
                break;
            case "*":
                if (isDigit(secondValue) && Integer.parseInt(secondValue) <= 10 && Integer.parseInt(secondValue) > 0) {
                    result = firstValue.repeat(Integer.parseInt(secondValue));
                } else {
                    throw new RuntimeException("Неправильный ввод");
                }
                break;

        }
        if (result.length() > 40) {
            result = result.substring(0, 40) + "...";
        }
        return "\"" + result + "\"";
    }

    private boolean containsQuote(String value) {
        if (value.charAt(0) == '\"' && value.charAt(value.length() - 1) == '\"') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private String removeQuotes(String value) {
        return value.substring(1, value.length() - 1);
    }
}
