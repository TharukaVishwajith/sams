package com.uok.sams.repository;

import com.uok.sams.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Modifying
    @Query(
            value =
                    "insert into Attendance (time_stamp, location_id, qr_client_id, recorded_by, student_id, created_date, updated_date) " +
                            "values (:timeStamp, :location, :qrClient, :recordedBy, :student,:createdDate, :updatedDate)",
            nativeQuery = true)
    Integer insertAttendance(@Param("timeStamp") Date timeStamp, @Param("location") Long location,
                    @Param("qrClient") Long qrClient, @Param("recordedBy") Long recordedBy,
                    @Param("student") Long student, @Param("createdDate") Date createdDate,
                    @Param("updatedDate") Date updatedDate);
}
