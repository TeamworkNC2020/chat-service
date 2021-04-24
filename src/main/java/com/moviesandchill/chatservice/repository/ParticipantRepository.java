package com.moviesandchill.chatservice.repository;

import com.moviesandchill.chatservice.entity.Participant;
import com.moviesandchill.chatservice.entity.pk.ParticipantPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, ParticipantPK> {

}
