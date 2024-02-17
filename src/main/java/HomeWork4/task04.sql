# 1. Вивести всі можливі пари рядків викладачів та груп.
select * from teachers
inner join academyhw3.lectures l on teachers.id_teachers = l.teachersId
inner join academyhw3.groups_lectures gl on l.id_lectures = gl.lecturesId
inner join academyhw3.`groups` g on gl.groupsId = g.id_groups;


# 4. Вивести імена та прізвища викладачів, які читають лекції у групі “5МІ”.
select teachers.name as 'Ім`я', teachers.surname as 'Прізвище' from teachers
inner join academyhw3.lectures l on teachers.id_teachers = l.teachersId
inner join academyhw3.groups_lectures gl on l.id_lectures = gl.lecturesId
inner join academyhw3.`groups` g on gl.groupsId = g.id_groups
where g.name = 'МІ';

# 6. Вивести назви кафедр та назви груп, які до них належать.
select departments.name as 'Кафедри', g.name as 'Групи' from departments
inner join academyhw3.`groups` g on departments.id_departments = g.departmentsId;

# 7. Вивести назви дисциплін, які читає викладач “Коваленко Ірина”.
select s.name as 'Предмет' from teachers
inner join academyhw3.lectures l on teachers.id_teachers = l.teachersId
inner join academyhw3.subjects s on l.subjectsId = s.id_subjects
where teachers.name = 'Ірина' and teachers.surname = 'Коваленко';

# 9. Вивести назви груп, що належать до Фізико- математичного факультету .
select `groups`.name as 'Група' from `groups`
inner join academyhw3.departments d on `groups`.departmentsId = d.id_departments
inner join academyhw3.faculties f on d.facultyId = f.id_faculties
where facultyId = 1;


# 10*. Вивести назви груп 5-го курсу, а також назву факультетів, до яких вони належать.
select `groups`.name as 'Група', f.name as 'Факультет' from `groups`
inner join academyhw3.departments d on `groups`.departmentsId = d.id_departments
inner join academyhw3.faculties f on d.facultyId = f.id_faculties
where year = 5;

# 11*. Вивести повні імена викладачів та лекції, які вони читають (назви дисциплін та груп),
# причому відібрати лише ті лекції, що читаються в аудиторії “102”.
select teachers.name as 'Ім`я', teachers.surname as 'Прізвище', s.name as 'Предмет', g.name as 'Група' from teachers
inner join academyhw3.lectures l on teachers.id_teachers = l.teachersId
inner join academyhw3.subjects s on l.subjectsId = s.id_subjects
inner join academyhw3.groups_lectures gl on l.id_lectures = gl.lecturesId
inner join academyhw3.`groups` g on gl.groupsId = g.id_groups
where l.lecturesRoom = '102';
