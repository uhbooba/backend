import { useNavigate } from 'react-router';
import LevelBar from '@/components/common/LevelBar';
import XTopBar from '@/components/layouts/XTopbar';
import PasswordInput from '@/components/common/PasswordInput'; 

const DepositPassword = () => {
  const navigate = useNavigate();

  const passwordComplete = (password: string[]) => {
    console.log("비밀번호 확인용 :", password.join('')); 
    navigate('/deposit/success');
  };

  return (
    <div>
      <XTopBar title="예금 가입 - 비밀번호" />
  
      <div className="mt-2 mb-12">
        <LevelBar currentLevel={5} totalLevel={5} />
      </div>

      <PasswordInput onComplete={passwordComplete} />
    </div>
  );
};

export default DepositPassword;
