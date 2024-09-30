# from config.database import Base
from sqlalchemy import Column, Integer, Text, Boolean, DateTime
from sqlalchemy.sql import func

from ..config.database import Base


class Quiz(Base):
    __tablename__ = "quiz"

    id = Column(Integer, primary_key=True, index=True, autoincrement=False)
    part = Column(Integer)
    number = Column(Integer)
    question = Column(Text)
    answer = Column(Boolean)
    comment = Column(Text)
    created_at = Column(DateTime, server_default=func.now())

    def __repr__(self):
        return f"<Quiz(id={self.id}, part={self.part}, number={self.number})>"