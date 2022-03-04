create database QuanLyThuVien
go
use QuanLyThuVien
go
create table Sach(
	maTaiLieu varchar(11) primary key,
	tenNXB nvarchar(100),
	soBanPhatHanh int,
	tenTacGia nvarchar(100),
	soTrang int
)
go
create table TapChi(
	maTaiLieu varchar(11) primary key,
	tenNXB nvarchar(100),
	soBanPhatHanh int,
	soPhatHanh int,
	thangPhatHanh nvarchar(12)
)
go
create table Bao(
	maTaiLieu varchar(11) primary key,
	tenNXB nvarchar(100),
	soBanPhatHanh int,
	ngayPhatHanh date
)

go
insert into Sach values
	('S01',N'Kim Đồng',1500,N'Nguyễn Nhật Ánh',85),
	('S02',N'Tuổi Trẻ',100,N'Phong',50)

go
insert into TapChi values
	('TC01',N'Đồng Nai',100,2,N'tháng 10'),
	('TC02','Model',150,8,N'tháng 9')

set dateformat dmy
go
insert into Bao values
	('B01',N'Thanh Niên',165,'06/12/2019'),
	('B02',N'Dân Trí',100,'15/2/2022')

go
create procedure sach_id
as
begin
declare @ma_next varchar(11)
declare @max int
select
	@max = count(maTaiLieu) + 1 from Sach where maTaiLieu like 'S'
set
	@ma_next = 'S' + RIGHT('0' + cast(@max as varchar(9)),9)
while (exists (select maTaiLieu from Sach where maTaiLieu=@ma_next))
begin
	set @max = @max +1
	set @ma_next = 'S' + RIGHT('0' + cast(@max as varchar(9)),9)
end
select @ma_next
end
--
go
create procedure tapChi_id
as
begin
declare @ma_next varchar(11)
declare @max int
select
	@max = count(maTaiLieu) + 1 from TapChi where maTaiLieu like 'TC'
set
	@ma_next = 'TC' + RIGHT('0' + cast(@max as varchar(8)),8)
while (exists (select maTaiLieu from TapChi where maTaiLieu=@ma_next))
begin
	set @max = @max +1
	set @ma_next = 'TC' + RIGHT('0' + cast(@max as varchar(8)),8)
end
select @ma_next
end
--
go
create procedure bao_id
as
begin
declare @ma_next varchar(11)
declare @max int
select
	@max = count(maTaiLieu) + 1 from Bao where maTaiLieu like 'B'
set
	@ma_next = 'B' + RIGHT('0' + cast(@max as varchar(9)),9)
while (exists (select maTaiLieu from Bao where maTaiLieu=@ma_next))
begin
	set @max = @max +1
	set @ma_next = 'B' + RIGHT('0' + cast(@max as varchar(9)),9)
end
select @ma_next
end
--
go
declare @return_value int
exec @return_value = dbo.bao_id
select 'ket qua' = @return_value
go