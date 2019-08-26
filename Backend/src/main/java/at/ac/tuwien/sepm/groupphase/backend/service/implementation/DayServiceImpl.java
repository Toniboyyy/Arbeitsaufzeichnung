package at.ac.tuwien.sepm.groupphase.backend.service.implementation;

import at.ac.tuwien.sepm.groupphase.backend.entity.Day;
import at.ac.tuwien.sepm.groupphase.backend.entity.DayFilter;
import at.ac.tuwien.sepm.groupphase.backend.entity.ProjectTime;
import at.ac.tuwien.sepm.groupphase.backend.entity.User;
import at.ac.tuwien.sepm.groupphase.backend.exception.NotFoundException;
import at.ac.tuwien.sepm.groupphase.backend.exception.ValidationException;
import at.ac.tuwien.sepm.groupphase.backend.repository.DayRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.ProjectTimeRepository;
import at.ac.tuwien.sepm.groupphase.backend.repository.UserRepository;
import at.ac.tuwien.sepm.groupphase.backend.service.DayService;
import at.ac.tuwien.sepm.groupphase.backend.validator.Implementation.Validator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;
    private final UserRepository userRepository;
    private final ProjectTimeRepository projectTimeRepository;
    private final Validator<Day> dayValidator;
    private final Validator<DayFilter> filterValidator;


    public DayServiceImpl(DayRepository dayRepository, UserRepository userRepository, ProjectTimeRepository projectTimeRepository, Validator<Day> dayValidator, Validator<DayFilter> dayFilterValidator) {
        this.dayRepository = dayRepository;
        this.userRepository = userRepository;
        this.projectTimeRepository = projectTimeRepository;
        this.dayValidator = dayValidator;
        this.filterValidator = dayFilterValidator;
    }

    @Override
    public Day add(Day day, String username) {
        dayValidator.validate(day);
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.get();
        day.setUser(user);
        return dayRepository.save(day);
    }

    @Override
    public Day change(Day day, String username){
        dayValidator.validate(day);
        if (day.getId() == null || day.getId() < 0){
            throw new ValidationException("Id can't be negativ.");
        }
        Optional<Day> dayOptional = dayRepository.getDayByUsernameAndId(username, day.getId());
        if(dayOptional.isEmpty()){
            throw new ValidationException("Day can't be found");
        }
        Day dayToSave = dayOptional.get();
        dayToSave.setWork_date(day.getWork_date());
        return dayRepository.save(dayToSave);
    }

    @Override
    public void delete(Long id, String username) {
        if (id < 0){
            throw new ValidationException("Id can't be negativ.");
        }
        Optional<Day> dayOptional = dayRepository.getDayByUsernameAndId(username, id);
        if(dayOptional.isEmpty()){
            throw new NotFoundException("Day couldn't be found.");
        }
        dayRepository.delete(dayOptional.get());
    }

    @Override
    public List<Day> getByMonthAndYear(DayFilter dayFilter, String username) {
        filterValidator.validate(dayFilter);
        dayFilter.getDates().withDayOfMonth(1);
        LocalDate start_date = dayFilter.getDates();
        LocalDate finish_date = dayFilter.getDates().plusMonths(1);
        List<Day> dayList = dayRepository.getAllByMonthAndYear(start_date, finish_date, username);
        return dayList;
    }

    @Override
    public Day getById(Long id, String username) {
        if(id < 0){
            throw new ValidationException("Id can't be negativ.");
        }
        Optional<Day> dayOptional = dayRepository.getByIdAndUser(id, username);
        if(dayOptional.isEmpty()){
            throw new NotFoundException("Day Not Found");
        }
        return dayOptional.get();
    }
}
