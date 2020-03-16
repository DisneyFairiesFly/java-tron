package org.tron.core.services.interfaceOnSolidity.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tron.core.services.http.CheckCrossTransactionCommitServlet;
import org.tron.core.services.http.GetRewardServlet;
import org.tron.core.services.interfaceOnSolidity.WalletOnSolidity;


@Component
@Slf4j(topic = "API")
public class CheckCrossTxCommitOnSolidityServlet extends CheckCrossTransactionCommitServlet {

  @Autowired
  private WalletOnSolidity walletOnSolidity;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    walletOnSolidity.futureGet(() -> super.doGet(request, response));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    walletOnSolidity.futureGet(() -> {
      super.doPost(request, response);
    });
  }
}
