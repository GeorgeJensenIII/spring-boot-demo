UPDATE `users`
set `password` = '$2a$10$kDF9JG4KRZ1KmQU8z8FiIeZtI3dzlgW8yG03m5fnKdoZ.Bg77BgWK'
where `username` = 'admin-01';


UPDATE `users`
set `password` = '$2a$10$MuXClQHsjtk2R6P/sbY6oeph.Z5owx4L2qWMOIQZGUSxG9hx/F2vC'
where `username` = 'user-01';

commit;