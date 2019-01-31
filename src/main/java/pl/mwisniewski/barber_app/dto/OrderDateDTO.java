package pl.mwisniewski.barber_app.dto;

import java.time.LocalDateTime;

public class OrderDateDTO {

    private LocalDateTime dateOfOrderContract;

    private String desc;

    public String getDesc() {
        return String.format("%d : %02d",dateOfOrderContract.getHour(),dateOfOrderContract.getMinute());
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getDateOfOrderContract() {
        return dateOfOrderContract;
    }

    public void setDateOfOrderContract(LocalDateTime dateOfOrderContract) {
        this.dateOfOrderContract = dateOfOrderContract;
    }
}
