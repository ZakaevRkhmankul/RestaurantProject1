package peaksoft.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.request.ChequeRequest;
import peaksoft.dto.responses.ChequeResponse;
import peaksoft.entities.Cheque;
import peaksoft.entities.MenuItem;
import peaksoft.entities.User;
import peaksoft.repository.ChequeRepo;
import peaksoft.repository.MenuItemRepo;
import peaksoft.repository.UserRepo;
import peaksoft.service.ChequeService;
import peaksoft.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChequeServiceImpl implements ChequeService {
    private final ChequeRepo chequeRepo;
    private final UserRepo userRepo;
    private final MenuItemRepo menuItemRepo;

    @Override
    public void saveCheque(ChequeRequest chequeRequest) {
        Cheque cheque = new Cheque();
        cheque.setPriceAverage(chequeRequest.getPriceAverage());
        cheque.setCreatedAt(LocalDate.now());

        User user = userRepo.findById(chequeRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        cheque.setUser(user);

        List<MenuItem> menuItems = menuItemRepo.findAllById(chequeRequest.getMenuItemIds());
        cheque.setMenuItems(menuItems);
        chequeRepo.save(cheque);

    }

    @Override
    public ChequeResponse getCheque(Long id) {
        Cheque cheque = chequeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cheque Not Found"));
        ChequeResponse chequeResponse = new ChequeResponse();
        User waiter = userRepo.findById(cheque.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        chequeResponse.setWaiterFullName(waiter.getFirstName() + " " + waiter.getLastName());
        chequeResponse.setMenuItems(cheque.getMenuItems());
        chequeResponse.setAveragePrice(cheque.getPriceAverage());
        double serviceFee = cheque.getPriceAverage() * 0.1;
        chequeResponse.setServicePercentage(10);
        chequeResponse.setGrandTotal(cheque.getPriceAverage() + serviceFee);
        return chequeResponse;
    }


    @Override
    public void deleteCheque(Long id) {
        chequeRepo.deleteById(id);
    }

    @Override
    public BigDecimal getTotalSumForWaiterByDay(Long waiterId, LocalDate date) {
        return chequeRepo.getTotalSumForWaiterByDay(waiterId, date);
    }

    @Override
    public BigDecimal getAverageChequeSumByDay(LocalDate date) {
        return chequeRepo.getAverageChequeSumByDay(date);
    }

}
