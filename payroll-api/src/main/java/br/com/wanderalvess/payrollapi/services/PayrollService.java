package br.com.wanderalvess.payrollapi.services;

import br.com.wanderalvess.payrollapi.domain.Payroll;
import br.com.wanderalvess.payrollapi.feignClients.UserFeign;
import br.com.wanderalvess.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public PayrollService(Environment env, UserFeign feign) {
        this.env = env;
        this.feign = feign;
    }

    public Payroll getPayment (long workedId, Payroll payroll) {
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port" );
        try {
            var user = feign.findById(workedId).getBody();
            if(Objects.nonNull(user)) {
                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                );
            }
        } catch (FeignException.NotFound ex) {
            throw new ObjectNotFoundException("Object not found");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }
}
