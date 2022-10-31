package br.com.timbrasil.portalcop.massivaservice.service;

import java.net.URL;

import org.springframework.stereotype.Service;

import br.com.timbrasil.fiber.cop.consultamsan.ConsultaMSAN;
import br.com.timbrasil.fiber.cop.consultamsan.ConsultaMSAN_Service;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsultaMSANService {

  private ConsultaMSANService() {
    super();
  }

  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException();
  }

  public static ConsultaMSAN getMSANService() {
    try {
      Dotenv dotenv = Dotenv.load();
      String url = dotenv.get("NewConsultaMsanEndpoint");
      URL endpoint = new URL(url);
      log.trace(String.format("URL: %s", url));
      ConsultaMSAN_Service service = new ConsultaMSAN_Service(endpoint);
      ConsultaMSAN stub = service.getConsultaMSANSOAP();
      return stub;
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return null;
  }
}
