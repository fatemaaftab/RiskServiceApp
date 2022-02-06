package main.java.RiskServiceApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController

public class RiskServiceController{
    @GetMapping("/localhost/risk/isuserknown?username=UserA ")

    // Scenario 1: IsUserKnown
    public List<Risk> getUserA(){
        //Returns hardcoded data, a real world application would return values depending upon the user type
        List<Risk> riskList = new ArrayList<Risk>();
        riskList.add(new Risk(true,true,true,"10.97.2.0/24",0,"Login Allowed"));
        riskList.add(new Risk(false,false,false,"10.97.2.0/24",0,"Login Denied"));
        return riskList;
    }

    //Scenario 2: Is IP Known
    @GetMapping("localhost/risk/isipknown?ip=192.168.101.5")
    public List<Risk> getIPKnown(){
        List<Risk> riskList = new ArrayList<Risk>();
        riskList.add(new Risk(true,true,true,"10.97.2.0/24",0,"Login Allowed"));
        riskList.add(new Risk(false,false,false,"10.97.2.0/24",0,"Login Denied"));
        return riskList;
    }

    //Scenario 3: Is IP Internal
    @GetMapping("/localhost/risk/ip=10.97.2.0/24")
    public List<Risk> getIPInternal(){
        List<Risk> riskList = new ArrayList<Risk>();
        riskList.add(new Risk(true,true,true,"10.97.2.0/24",0,"Login Allowed"));
        riskList.add(new Risk(false,false,false,"10.97.2.0/24",0,"Login Denied"));
        return riskList;
    }

    //Scenario 4: Failed login Count last week
    @GetMapping("localhost/risk/failedlogincountlastweek ")
    public List<Risk> getfailedLoginCountLastWeek(){
        List<Risk> riskList = new ArrayList<Risk>();
        riskList.add(new Risk(true,true,true, "10.97.2.0/24",0,"Login Allowed"));
        riskList.add(new Risk(false,false,true,"10.97.2.0/24",4,"Login Denied"));
        return riskList;
    }
}
