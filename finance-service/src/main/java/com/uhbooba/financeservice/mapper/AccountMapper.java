package com.uhbooba.financeservice.mapper;

import com.uhbooba.financeservice.dto.finapi.response.demand_deposit.DemandDepositAccountResponse;
import com.uhbooba.financeservice.dto.finapi.response.deposit.DepositAccountResponse;
import com.uhbooba.financeservice.dto.finapi.response.exchange.ForeignCurrencyAccountResponse;
import com.uhbooba.financeservice.dto.finapi.response.savings.SavingsAccountResponse;
import com.uhbooba.financeservice.dto.response.AccountResponse;
import com.uhbooba.financeservice.entity.Account;
import com.uhbooba.financeservice.entity.AccountType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(source = "accountTypeCode", target = "accountTypeCode")
    Account toEntity(DemandDepositAccountResponse dto);

    // 문자열을 AccountType 열거형으로 변환하는 메서드
    default AccountType stringToAccountType(String accountTypeCode) {
        return AccountType.fromCode(accountTypeCode);
    }

    Account toEntity(DepositAccountResponse dto);

    Account toEntity(SavingsAccountResponse dto);

    Account toEntity(ForeignCurrencyAccountResponse dto);

    AccountResponse toDto(Account account);
}
