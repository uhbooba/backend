import { atom } from 'jotai';
import { SavingAccountDetail } from '@/types/saving';

interface SelectedSavingsProduct {
  name: string;
  interestRate: number;
  minimumAmount: number;
  earlyInterestRate: number;
}

export const selectAccountAtom = atom<number | null>(null); // 선택한 계좌
export const selectMoneyAtom = atom(''); // 선택한 가입 금액
export const selectPeriodAtom = atom(''); // 선택한 가입 기간
export const maturityDateAtom = atom(''); // 만기일
export const selectedSavingsProductAtom = atom<SelectedSavingsProduct | null>(
  null,
);
export const checkAtom = atom('');
export const errorsAtom = atom({
  name: '',
  idNumber: '',
  phoneNumber: '',
  accountNumber: '',
});

// 생성한 적금 계좌 정보
export const savingAccountAtom = atom<SavingAccountDetail | null>(null);
// 적금 가입 시 출금계좌 정보를 저장할거
export const withdrawalAccountAtom = atom<SavingAccountDetail | null>(null);
