import StartSection from "@/components/Home/StartSection";
import SamplesSection from "@/components/Home/SamplesSection";
import VoxSection from "@/components/Home/VoxSection";
import AboutMeSection from "@/components/Home/AboutMeSection";
import ContentWrapper from "@/components/ContentWrapper";
import CustomContainer from "@/components/CustomContainer";

const Home = () => {
  return (
    <ContentWrapper>
      <CustomContainer>
        <StartSection />
        <SamplesSection />
        <VoxSection />
        <AboutMeSection />
      </CustomContainer>
    </ContentWrapper>
  );
};

export default Home;
