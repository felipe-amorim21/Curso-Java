package service;

import entities.Contract;
import entities.Installment;

import java.time.LocalDate;

public class ContracService {
    private OnlinePaymentService onlinePaymentService;

    public ContracService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months ){
        Double basicAmount =  contract.getTotalValue() / months;
        for(int i =1; i<= months; i++){
            LocalDate dueDate = contract.getDate().plusMonths(i);
            Double interest = onlinePaymentService.interest(basicAmount, i);
            Double fee = onlinePaymentService.paymentFee(basicAmount + interest);
            Double amount = basicAmount + interest + fee;

            contract.getInstallmentList().add(new Installment(dueDate, amount));
        }
    }
}
