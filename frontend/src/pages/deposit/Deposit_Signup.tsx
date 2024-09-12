import Button from '@/components/common/buttons/Button';
import BackButton from '@/components/common/buttons/BackButton';
import { Input } from '@/components/common/Input';
import { useNavigate } from 'react-router';
import { useState } from 'react';
// import { useMediaQuery } from 'react-responsive';
import BigModal from '@/components/modals/Big_Modal';

const DepositSignup = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const navigate = useNavigate();

  const OpenModal = () => {
    setIsModalOpen(true);
  };

  const GoBack = () => {
    navigate(-1);
  };

  const ModalConfirm = () => {
    setIsModalOpen(false);
    navigate('/deposit/agree');
  };

  const ModalClose = () => {
    setIsModalOpen(false);
  };

  return (
    <div className='w-full overflow-x-hidden'>
      <div className='bg-gray-400 text-center'>
        <span>여기는 휴대폰 상단 상태바</span>
      </div>

      {/* 상단바 */}
      <div className='flex items-center justify-between border-b-4 bg-white py-4'>
        <BackButton className='ml-4' />
        <span className='absolute left-1/2 -translate-x-1/2 transform text-xl font-bold'>
          예금 가입1 - 개인정보
        </span>
      </div>

      <div className='bg-gray-400 py-4 text-center'>단계표시바</div>

      <Input className='w-full' />

      <div className='mx-4 mt-8 flex justify-between space-x-4'>
        <Button
          label='이전'
          size='large'
          color='orange'
          className='flex-grow'
          onClick={() => GoBack()}
        />
        <Button
          label='다음'
          size='medium'
          color='orange'
          className='flex-grow'
          onClick={() => OpenModal()}
        />
      </div>

      <BigModal
        isOpen={isModalOpen}
        ModalClose={ModalClose}
        GoNext={ModalConfirm}
        imageSrc='/assets/icons/warning.png'
        title='교육용 어플입니다.'
        description={
          <>
            실제 은행 예금 상품을 가입할 때는 <br />
            더 많은 정보를 입력해야 합니다. <br />
            해당 어플은 교육용 어플이기 때문에 <br />
            실제보다 적은 정보만 입력했습니다.
          </>
        }
      />
    </div>
  );
};

export default DepositSignup;
