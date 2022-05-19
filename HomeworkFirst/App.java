package HomeworkFirst;

 public class App {

    //Создаем участников


    public static void main(String[] args) {

        Participants participants1 = new Participants("Ирина", 350, 100, 15);
        Participants participants2 = new Participants("Валера", 1000, 500, 35);
        Participants participants3 = new Participants("Саша", 850, 450, 33);
        Participants participants4 = new Participants("Надя",400, 75,13);

        Participants[] participants = {participants1, participants2, participants3, participants4};

        Team team = new Team("Массив", participants );

        Course c = new Course (750, 300, 32); // Создаем полосу препятствий
        c.doIt(team); 
        team.showResults();

    }

}

