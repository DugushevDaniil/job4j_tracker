package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        int i = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                i++;
                rsl = subject.score() + rsl;
            }
        }
        rsl = rsl / i;
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        int i = 0;
        double rsl = 0;
        List<Label> students = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl = subject.score() + rsl;
                i++;
            }
            rsl = rsl / i;
            students.add(new Label(pupil.name(), rsl));
            rsl = 0;
            i = 0;
        }
        return students;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        int i = 0;
        double rsl = 0;
        List<Label> srcSubjects = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<Double> score1 = new ArrayList<>();
        double score2;
        for (Pupil pupil : pupils) {
            i++;
            for (Subject subject : pupil.subjects()) {
                if (!names.contains(subject.name())) {
                    names.add(subject.name());
                }
                score2 = subject.score();
                score1.add(score2);
            }
        }
        for (int k = 0; names.size() > k; k++) {
            for (int j = 0; score1.size() > j; j = j + i) {
                rsl = score1.get(j) + rsl;
            }
            srcSubjects.add(new Label(names.get(k), rsl / i));
            rsl = 0;
            score1.remove(0);
        }
        return srcSubjects;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> students = averageScoreByPupil(pupils);
        double bestScore = 0;
        int i = 0;
        String nameOfTheBest = "";
        for (Label student : students) {
            i++;
            if (bestScore < student.score()) {
                bestScore = student.score();
                nameOfTheBest = student.name();
            }
        }
        return new Label(nameOfTheBest, bestScore * i);
    }

    public static Label bestSubject(List<Pupil> pupils) {
       List<Label> subjects = averageScoreBySubject(pupils);
        double bestScore = 0;
        int i = 0;
        String nameOfTheBest = "";
        for (Label subject : subjects) {
            i++;
            if (bestScore < subject.score()) {
                bestScore = subject.score();
                nameOfTheBest = subject.name();
            }
        }
        return new Label(nameOfTheBest, bestScore * i);
    }
}