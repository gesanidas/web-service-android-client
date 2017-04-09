using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using MyCompany.Models;

namespace MyCompany.Migrations
{
    [DbContext(typeof(MyCompanyContext))]
    [Migration("20170408163805_InitialCreate")]
    partial class InitialCreate
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
            modelBuilder
                .HasAnnotation("ProductVersion", "1.1.1")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("MyCompany.Models.Employee", b =>
                {
                    b.Property<int>("ID")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Email");

                    b.Property<string>("Name");

                    b.Property<string>("Password");

                    b.Property<int>("Phone");

                    b.Property<string>("Title");

                    b.HasKey("ID");

                    b.ToTable("Employee");
                });

            modelBuilder.Entity("MyCompany.Models.Skill", b =>
                {
                    b.Property<int>("SkillID")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Description");

                    b.Property<int>("EmployeeID");

                    b.HasKey("SkillID");

                    b.HasIndex("EmployeeID");

                    b.ToTable("Skill");
                });

            modelBuilder.Entity("MyCompany.Models.Skill", b =>
                {
                    b.HasOne("MyCompany.Models.Employee", "Employee")
                        .WithMany("Skills")
                        .HasForeignKey("EmployeeID")
                        .OnDelete(DeleteBehavior.Cascade);
                });
        }
    }
}
