public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name.startsWith(" ")){
            return false;
        } else if(!name.contains(" ")) {
            return false;
        } else  if (name.endsWith(" ")){
            return  false;
            // В коде ниже проверяется, что первый в строке индекс, по которому встречается
            // пробел, равен последнему в строке индексу, по которому есть пробел.
            //Таким образом алгоритм находит первый пробел от начала строки, затем находит первый от конца строки.
            //Если их индексы совпадают, то получается, что это один и тот же пробел, следовательно других в строке нет.
        }else if (!(name.indexOf(" ") == name.lastIndexOf(" "))){
            return false;
        }else if(name.length() < 3 | name.length()>19){
            return false;
        } else {
            return true;
        }
    }
}



