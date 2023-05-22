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
        List<Label> srcSubjects = new ArrayList<>();
        Map<String, Integer> subjects = new HashMap<>();
        int i = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjects.containsKey(subject.name())) {
                    subjects.put(subject.name(), subjects.get(subject.name()) + subject.score());
                }
                subjects.putIfAbsent(subject.name(), subject.score());
            }
            i = subjects.size();
        }
        for (String srcSubject : subjects.keySet()) {
            srcSubjects.add(new Label(srcSubject, subjects.get(srcSubject) / i));
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
        List<Label> bestSubjects = new ArrayList<>();
        Map<String, Integer> subjects = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (subjects.containsKey(subject.name())) {
                    subjects.put(subject.name(), subjects.get(subject.name()) + subject.score());
                }
                subjects.putIfAbsent(subject.name(), subject.score());
            }
        }
        for (String srcSubject : subjects.keySet()) {
            bestSubjects.add(new Label(srcSubject, subjects.get(srcSubject)));
        }
        bestSubjects.sort(Comparator.naturalOrder());
        return bestSubjects.get(bestSubjects.size() - 1);
    }
}