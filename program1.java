// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Пример 1:
// Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
// Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';

import java.util.Arrays;

public class program1 {
    public static void main(String[] args) {
        String stringToFilter = "\"name:Ivanov\" \"country:Russia\" \"city:null\" \"age:null\"";
        String[] stringToFilterArrayNew = stringToFilter.split("\"?\\s+\"?|:\"?");
        System.out.println(Arrays.toString(stringToFilterArrayNew));

        StringBuilder filterBuilder = new StringBuilder();

        for (int i = 0; i < stringToFilterArrayNew.length + 1; i += 2) {
            if (i + 1 < stringToFilterArrayNew.length) { 
                String key = stringToFilterArrayNew[i];
                String value = stringToFilterArrayNew[i + 1];
                if (!value.equals("null\"") && !value.equals("null")) {
                    if (filterBuilder.length() > 0) {
                        filterBuilder.append(" and ");
                    }
                    filterBuilder.append(key).append(" = ").append(value).append("\"");
                }
            }
        }

        String filter = filterBuilder.toString();
        System.out.println("SELECT * FROM USER WHERE " + filter);

    }
}
