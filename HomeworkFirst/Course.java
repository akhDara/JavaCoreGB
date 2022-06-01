package HomeworkFirst;

public class Course {
    // Создать конкурсы
        public int runDistance;
        public int swimDistance;
        public int jumpHeight;

        public Course(int runDistance, int swimDistance, int jumpHeight) {
            this.runDistance = runDistance;
            this.swimDistance = swimDistance;
            this.jumpHeight = jumpHeight;
        }

        void doIt (Team team) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if ((team.participants[i].runConstrains >= runDistance) & (team.participants[i].swimConstrains >= swimDistance) & (team.participants[i].jumpConstrains >= jumpHeight)) {
                    count += 1;
                    team.participants[i].done = true;
                }
            }
            if (count == 4) team.done = true;
        }
}
