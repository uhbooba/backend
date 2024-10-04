package com.uhbooba.financeservice.controller.finance;

import com.uhbooba.financeservice.dto.CommonResponse;
import com.uhbooba.financeservice.dto.UserHeaderInfo;
import com.uhbooba.financeservice.dto.finapi.request.deposit.DepositAccountCreateRequest;
import com.uhbooba.financeservice.dto.finapi.request.deposit.DepositCreateRequest;
import com.uhbooba.financeservice.dto.finapi.response.deposit.DepositAccountDeleteResponse;
import com.uhbooba.financeservice.dto.finapi.response.deposit.DepositAccountResponse;
import com.uhbooba.financeservice.dto.finapi.response.deposit.DepositEarlyTerminationInterestResponse;
import com.uhbooba.financeservice.dto.finapi.response.deposit.DepositExpiryInterestResponse;
import com.uhbooba.financeservice.dto.finapi.response.deposit.DepositResponse;
import com.uhbooba.financeservice.service.DepositService;
import com.uhbooba.financeservice.util.CommonUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "예금 API", description = "예금 관련 API")
@RequestMapping("/finances/deposits")
public class DepositController {

    private final DepositService depositService;

    @PostMapping("/products")
    @Operation(summary = "[사용 X] 예금 상품 만들기")
    public CommonResponse<DepositResponse> createDeposit(
        @Valid @RequestBody DepositCreateRequest dto
    ) {
        return CommonResponse.ok("예금 상품 생성 완료", depositService.createDeposit(dto));
    }

    @PostMapping("/products/init")
    @Operation(summary = "[사용 주의] 예금 상품 초기 세팅")
    public CommonResponse<?> initDeposit() {
        depositService.depositInitSetting();
        return CommonResponse.ok("예금 상품 초기 세팅 완료");
    }

    @GetMapping("/products")
    @Operation(summary = "예금 상품 전체 조회")
    public CommonResponse<List<DepositResponse>> getDepositProducts() {
        return CommonResponse.ok("예금 상품 조회 완료", depositService.getAllDeposits());
    }

    @PostMapping("/accounts")
    @Operation(summary = "예금 계좌 생성")
    public CommonResponse<DepositAccountResponse> createDepositAccount(
        @RequestHeader HttpHeaders headers,
        @Valid @RequestBody DepositAccountCreateRequest dto
    ) {
        UserHeaderInfo userHeaderInfo = CommonUtil.getUserHeaderInfo(headers);
        return CommonResponse.ok("예금 계좌 생성 완료",
                                 depositService.createDepositAccount(userHeaderInfo, dto));
    }

    @GetMapping("/accounts/expiry-interests")
    @Operation(summary = "예금 만기 이자 조회")
    public CommonResponse<DepositExpiryInterestResponse> getDepositExpiryInterest(
        @RequestHeader HttpHeaders headers,
        @RequestParam("accountNo") String accountNo
    ) {
        UserHeaderInfo userHeaderInfo = CommonUtil.getUserHeaderInfo(headers);
        return CommonResponse.ok("예금 만기 이자 조회 완료",
                                 depositService.getDepositExpiryInterest(userHeaderInfo,
                                                                         accountNo));
    }

    @GetMapping("/accounts/early-termination-interest")
    @Operation(summary = "예금 중도 해지 시 이자 조회")
    public CommonResponse<DepositEarlyTerminationInterestResponse> getDepositEarlyTerminationInterest(
        @RequestHeader HttpHeaders headers,
        @RequestParam("accountNo") String accountNo
    ) {
        UserHeaderInfo userHeaderInfo = CommonUtil.getUserHeaderInfo(headers);
        return CommonResponse.ok("예금 중도 해지 이자 조회 완료",
                                 depositService.getDepositEarlyTerminationInterest(userHeaderInfo,
                                                                                   accountNo));
    }

    @DeleteMapping("/accounts")
    @Operation(summary = "[사용 X] 입출금 계좌 삭제")
    public CommonResponse<DepositAccountDeleteResponse> deleteDepositAccount(
        @RequestHeader HttpHeaders headers,
        @RequestParam("accountNo") String accountNo
    ) {
        UserHeaderInfo userHeaderInfo = CommonUtil.getUserHeaderInfo(headers);
        return CommonResponse.ok("입출금 계좌 삭제 완료",
                                 depositService.deleteDepositAccount(userHeaderInfo, accountNo));
    }

    @GetMapping("/accounts/detail")
    @Operation(summary = "예금 계좌 상세 조회")
    public CommonResponse<DepositAccountResponse> getDepositAccount(
        @RequestHeader HttpHeaders headers,
        @RequestParam("accountNo") String accountNo
    ) {
        UserHeaderInfo userHeaderInfo = CommonUtil.getUserHeaderInfo(headers);
        return CommonResponse.ok("예금 계좌 상세 조회 완료",
                                 depositService.getDepositAccount(userHeaderInfo, accountNo));
    }

    @GetMapping("/accounts")
    @Operation(summary = "사용자의 예금 계좌 목록 조회")
    public CommonResponse<List<DepositAccountResponse>> getDepositAccounts(
        @RequestHeader HttpHeaders headers
    ) {
        UserHeaderInfo userHeaderInfo = CommonUtil.getUserHeaderInfo(headers);
        return CommonResponse.ok("사용자 예금 계좌 목록 조회 완료",
                                 depositService.getAllDepositAccounts(userHeaderInfo));
    }
}