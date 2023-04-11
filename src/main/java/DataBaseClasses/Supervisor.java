package DataBaseClasses;

import DataBaseClasses.Worker;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Supervisor {
    private Set<Worker> workerByUpperPosition;
    private Set<Worker> workerByLowerPosition;
    private int lowerPosition;

    @ManyToMany
    @JoinColumn(name = "upper_position", referencedColumnName = "id")
    public Set<Worker> getWorkerByUpperPosition() {
        return workerByUpperPosition;
    }

    public void setWorkerByUpperPosition(Set<Worker> workerByUpperPosition) {
        this.workerByUpperPosition = workerByUpperPosition;
    }

    public void appendWorkerByUpperPosition(Worker worker){
        workerByUpperPosition.add(worker);
    }

    @ManyToMany
    @JoinColumn(name = "lower_position", referencedColumnName = "id")
    public Set<Worker> getWorkerByLowerPosition() {
        return workerByLowerPosition;
    }

    public void setWorkerByLowerPosition(Set<Worker> workerByLowerPosition) {
        this.workerByLowerPosition = workerByLowerPosition;
    }

    public void appendWorkerByLowerPosition(Worker worker){
        workerByLowerPosition.add(worker);
    }

    @Id
    @Column(name = "lower_position")
    public int getLowerPosition() {
        return lowerPosition;
    }

    public void setLowerPosition(int lowerPosition) {
        this.lowerPosition = lowerPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supervisor that = (Supervisor) o;

        if (lowerPosition != that.lowerPosition) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return lowerPosition;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "workerByUpperPosition=" + workerByUpperPosition +
                ", workerByLowerPosition=" + workerByLowerPosition +
                '}';
    }
}
