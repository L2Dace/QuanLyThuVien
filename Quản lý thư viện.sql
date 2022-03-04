create database QuanLyThuVien2
go
use QuanLyThuVien2
go
create table Sach(
	maTaiLieu char(5) primary key,
	tenNXB nvarchar(100),
	soBanPhatHanh int,
	tenTacGia nvarchar(100),
	soTrang int
)
go
create table TapChi(
	maTaiLieu char(5) primary key,
	tenNXB nvarchar(100),
	soBanPhatHanh int,
	soPhatHanh int,
	thangPhatHanh nvarchar(12)
)
go
create table Bao(
	maTaiLieu char(5) primary key,
	tenNXB nvarchar(100),
	soBanPhatHanh int,
	ngayPhatHanh date
)

go
insert into Sach values
	('SA001',N'Kim Đồng',1500,N'Nguyễn Nhật Ánh',85),
	('SA002',N'Tuổi Trẻ',100,N'Phong',50)

go
insert into TapChi values
	('TC001',N'Đồng Nai',100,2,N'tháng 10'),
	('TC002','Model',150,8,N'tháng 9')

set dateformat dmy
go
insert into Bao values
	('BA001',N'Thanh Niên',165,'06/12/2019'),
	('BA002',N'Dân Trí',100,'15/2/2022')

