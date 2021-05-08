-- For H2
set referential_integrity false;
truncate table world restart identity;
set referential_integrity true;

insert into `world` (`id`, `project_key`, `name`, `description`, `dev_policy_agree`) values
(1, 'io.homo_efficio.zepeto.creator.in-app-game.gym-01', '체육관 월드', '운동충들 가즈아ㅏㅏㅏ', true),
(2, 'io.homo_efficio.zepeto.creator.in-app-game.museum-01', '박물관 world', '호기심충들 가즈아ㅏㅏㅏ', true),
(3, 'io.homo_efficio.zepeto.creator.in-app-game.aquarium-01', '수족관 월드', '옥토넛 가즈아ㅏㅏㅏ', true),
(4, 'io.homo_efficio.zepeto.creator.in-app-game.botanical-01', '식물원 월드', '대나무 가즈아ㅏㅏㅏ', true),
(5, 'io.homo_efficio.zepeto.creator.in-app-game.food-court-01', '먹방 월드', '돼식가 가즈아ㅏㅏㅏ', true),
(6, 'io.homo_efficio.zepeto.creator.in-app-game.resort-01', '리조트 월드', '보라보라 가즈아ㅏㅏㅏ', true)
;
