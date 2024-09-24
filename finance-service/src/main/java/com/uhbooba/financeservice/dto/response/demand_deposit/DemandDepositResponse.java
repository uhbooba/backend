package com.uhbooba.financeservice.dto.response.demand_deposit;

public record DemandDepositResponse(
    String accountTypeUniqueNo,
    String bankCode,
    String bankName,
    String accountTypeCode,
    String accountTypeName,
    String accountName,
    String accountDescription,
    String accountType
) {

}
