package at.ac.tuwien.sepm.groupphase.backend.service;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;

import java.util.List;
import java.util.Set;

public interface DayService {

    /**
     * @param day to add to the database
     * @param username of the user which saves the day in the db
     * @return the day saved in the db
     */
    Day add(Day day, String username);

    /**
     * @param day containing the date and the id of the day to change
     * @param username of the user which changes the day in the db
     * @return the changed day in the db
     */
    Day change(Day day, String username);

    /**
     * @param id of the day to delete
     * @param username of the user which wants to delete the day
     */
    void delete(Long id, String username);

    /**
     * @param dayFilter filter containing a date
     * @param username of the user requesting the days
     * @return List of days containing the days of the month specified in filter
     */
    List<Day> getByMonthAndYear(DayFilter dayFilter, String username);

    /**
     * @param id of day to search in db
     * @param username  of the day to search for in db
     * @return the day with the id
     */
    Day getById(Long id, String username);
}
